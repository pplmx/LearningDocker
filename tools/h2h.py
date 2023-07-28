import os

import toml
import yaml

HEXO_TO_HUGO_KEY_MAP = {
    'title': 'title',
    'date': 'date',
    'updated': 'lastmod',
    'categories': 'categories',
    'tags': 'tags',
    'description': 'description',
    'keywords': 'keywords',
    'permalink': 'slug',
}

HUGO_TO_HEXO_KEY_MAP = {v: k for k, v in HEXO_TO_HUGO_KEY_MAP.items()}


def convert_front_matter(front_matter, key_map):
    front_matter_dict = toml.loads(front_matter)
    converted_dict = {}
    for key, value in front_matter_dict.items():
        converted_key = key_map.get(key, key)
        converted_dict[converted_key] = value
    converted_front_matter = yaml.dump(converted_dict, sort_keys=False)
    return f'---\n{converted_front_matter}---'


def convert_markdown(hexo_path, hugo_path, key_map):
    with open(hugo_path, 'r') as f:
        hugo_content = f.read()
    hugo_front_matter = hugo_content.split('---')[1]
    hexo_front_matter = convert_front_matter(hugo_front_matter, key_map)
    hugo_body = hugo_content.split('---')[2]
    hexo_content = f'{hexo_front_matter}\n\n{hugo_body}'
    with open(hexo_path, 'w') as f:
        f.write(hexo_content)


def convert_posts(hugo_dir, hexo_dir, key_map):
    if not os.path.exists(hexo_dir):
        os.makedirs(hexo_dir)
    for filename in os.listdir(hugo_dir):
        if filename.endswith('.md'):
            hugo_path = os.path.join(hugo_dir, filename)
            hexo_path = os.path.join(hexo_dir, filename)
            convert_markdown(hexo_path, hugo_path, key_map)


def convert_hugo_to_hexo(hugo_dir, hexo_dir):
    convert_posts(hugo_dir, hexo_dir, HUGO_TO_HEXO_KEY_MAP)


def convert_hexo_to_hugo(hexo_dir, hugo_dir):
    convert_posts(hexo_dir, hugo_dir, HEXO_TO_HUGO_KEY_MAP)


def test():
    src_hexo_dir = '/path/to/hexo/posts'
    src_hugo_dir = '/path/to/hugo/content/posts'

    dst_hexo_dir = '/path/to/hexo/posts'
    dst_hugo_dir = '/path/to/hugo/content/posts'

    convert_hugo_to_hexo(src_hugo_dir, dst_hexo_dir)
    print(f'{len(os.listdir(src_hugo_dir))} files have been converted from Hugo to Hexo format.')

    convert_hexo_to_hugo(src_hexo_dir, dst_hugo_dir)
    print(f'{len(os.listdir(src_hexo_dir))} files have been converted from Hexo to Hugo format.')


if __name__ == '__main__':
    test()
