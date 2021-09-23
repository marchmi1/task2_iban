IBAN VALIDATOR:


IBAN is an international bank account numbering standard that allows you to transfer funds to foreign accounts
and to receive transfers from foreign entities to domestic bank accounts.
An IBAN can be validated performing a basic mod-97 operation on it (as described in ISO 7064).
 

A. Write a program
Write a program that will allow you to check if the given IBAN number is correct.
Use the following algorithm:

1. Move the first 4 characters of the IBAN number to its end.
2. Replace each letter in the string with two digits, where "A" = "10", "B" = "11", ..., "Z" = "35".
3. From the resulting number, calculate modulo 97.
4. If the remainder of modulo is 1, then the checksum is correct and IBAN is valid.
Please note that we consider the full IBAN (including country code).
Assume that it is a letter-digit string, 14 to 34 characters long.

As a user, I would like to be able to enter a number with extra spaces, which the program will ignore.

Example
We consider an account with an IBAN number PL83101010230000261395100000

0. Number has 28 characters, which is correct.
1. After transferring the first 4 characters to the end of the number,
we get the following alphanumeric sequence: 101010230000261395100000PL83.
2. We convert letters into numbers, we get the number: 101010230000261395100000252183.
3. We calculate the remainder when this number is divided by 97. The remainder is 1.
4. The remainder of the division is 1, which means the checksum is correct and the given IBAN is valid.
 

B. Use your program to check if the given numbers are valid IBANs:
Correct / Incorrect   PL83101010230000261395100000
Correct / Incorrect   PL 83 1010 1023 0000 2613 9510 0000
Correct / Incorrect   PL83101010230000261395100001
Correct / Incorrect   PL10105000997603123456789123
Correct / Incorrect   PL8310101023000026139510000!

Correct / Incorrect   AT483200000012345864
Correct / Incorrect   NO 93 8601 1117948
Correct / Incorrect   NO 93 8601 1117947
Correct / Incorrect   kw81CBKU0000000000001234560101
Correct / Incorrect   MCU5810096180790123456789085