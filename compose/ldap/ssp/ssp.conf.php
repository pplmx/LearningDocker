<?php
// general
$keyphrase = "mysecret";
$debug = true;
$smarty_debug = true;
$login_forbidden_chars = "*()&|";

// ldap connection
$ldap_url = "ldap://ldap-srv:1389";
$ldap_binddn = "cn=admin,dc=chaos,dc=io";
$ldap_bindpw = "secret";
$who_change_password = "user";
$ldap_base = "ou=users,dc=chaos,dc=io";
$ldap_filter = "(&(objectClass=person)(uid={login}))";

// password policy
$hash = "auto";
$pwd_min_length = 12;
$pwd_max_length = 30;
$pwd_min_lower = 1;
$pwd_min_upper = 1;
$pwd_min_digit = 1;
$pwd_min_special = 1;
$pwd_special_chars = "^a-zA-Z0-9"; // This means special characters are all characters except alphabetical letters and digits.
$pwd_no_special_at_ends = true; // Special characters are not allowed at the beginning or at the end of the password.
$pwd_show_policy = "always"; // never, onerror, always
$pwd_show_policy_pos = "above"; // above, below
$show_extended_error = true;

// reset by mail tokens
$use_tokens = true;
$mail_address_use_ldap = true;

?>
