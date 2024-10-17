# Java_faculty_project

## Life insurance regstration.

The system stores information about users (insured / insurer) and their contracts. Unless stated otherwise all data is mandatory.
The system records the following data about each user:
● unique numerical identifier (ID),
● name,
● surname,
● social security number,
● e-mail,
● address of permanent residence,
● mailing address,
● list of contracts (contracts concluded by the user)
If the user's mailing address is not defined, the user's address is used
of permanent residence. The address consists of:
● ZIP code,
● the name of the municipality,
● street name,
● reference number of the house
Types of contracts
The system registers two types of contracts: life insurance and non-life insurance. Every contract has
assigned to:
● unique contract number (ID),
● date of creation,
● a reference to the insurer (the user who concluded the contract),
● insurance start and end date,
● the amount of the insurance payment (the amount for which it is insured),
● the amount of the monthly installment.
Life insurance
Life insurance contracts include:
● travel insurance:
○ reference to the insured
○ within the EU / outside the EU
○ purpose of the trip (numerical value, permitted are: work, recreation, sports, etc
etc.)
● accident insurance
○ reference to the insured
○ permanent consequences of an accident (sum insured in euros)
○ Death due to an accident (sum insured in euros)
○ Daily compensation for hospitalization (sum insured in euros)
○ Territorial validity (numeric value, allowed values ​​are: "Slovakia",
"World", "World + Slovakia")
Non-life insurance
Non-life insurance contracts include:
● household insurance
○ property type (numeric value, allowed values ​​are: "Apartment", "Family
house - brick", "Family house - wooden")
○ property address
○ value of the property in euros
○ value of household equipment in euros
● home and apartment insurance
○ property type (numeric value, allowed values ​​are: "Apartment", "Family
house - brick", "Family house - wooden")
○ property address
○ value of the property in euros
○ additional garage insurance (yes / no)
API functionality
The system enables the following functionality (API):
● User management:
○ Adding a new user
○ Editing an existing user
○ Listing of all users in the system
○ Listing the details of a specific user (according to the unique numerical
identifier)
● Management of insurance contracts:
○ Establishing an insurance policy for the user
○ Modification of an existing contract
○ List of all insurance contracts
○ List of insurance contracts for the given insurer (according to the unique
of the user's numeric identifier) ​​- lists only contracts where it is given
the user to the insurer!
To demonstrate the functionality, create at least one user in the main method and set it up
him at least one arbitrary contract.

