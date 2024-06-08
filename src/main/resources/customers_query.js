
db.customers.createIndex({ uniqueCode: 1 }, { unique: true });

db.customers.insertMany(   
[
    {
        "uniqueCode": "QeCVfZKCyo+UFXLvrwmpVw==",
        "name": "Juan Carlos",
        "lastName": "Solar Torres",
        "dni": "43032393",
        "age": 39,
        "address": "Piura",
        "phoneNumber": "1234567890",
        "email": "juan@example.com"
    },
    {
        "uniqueCode": "DEF456",
        "name": "Jane",
        "lastName": "Smith",
        "dni": "87654321",
        "age": 25,
        "address": "456 Elm St",
        "phoneNumber": "9876543210",
        "email": "jane@example.com"
    },
    {
        "uniqueCode": "GHI789",
        "name": "Michael",
        "lastName": "Johnson",
        "dni": "45678901",
        "age": 40,
        "address": "789 Oak St",
        "phoneNumber": "2345678901",
        "email": "michael@example.com"
    },
    {
        "uniqueCode": "JKL012",
        "name": "Emily",
        "lastName": "Davis",
        "dni": "32109876",
        "age": 35,
        "address": "987 Pine St",
        "phoneNumber": "3456789012",
        "email": "emily@example.com"
    },
    {
        "uniqueCode": "MNO345",
        "name": "David",
        "lastName": "Martinez",
        "dni": "67890123",
        "age": 28,
        "address": "654 Cedar St",
        "phoneNumber": "4567890123",
        "email": "david@example.com"
    },
    {
        "uniqueCode": "PQR678",
        "name": "Sarah",
        "lastName": "Garcia",
        "dni": "89012345",
        "age": 33,
        "address": "321 Birch St",
        "phoneNumber": "5678901234",
        "email": "sarah@example.com"
    },
    {
        "uniqueCode": "STU901",
        "name": "Chris",
        "lastName": "Lopez",
        "dni": "23456789",
        "age": 27,
        "address": "456 Walnut St",
        "phoneNumber": "6789012345",
        "email": "chris@example.com"
    },
    {
        "uniqueCode": "VWX234",
        "name": "Michelle",
        "lastName": "Hernandez",
        "dni": "90123456",
        "age": 42,
        "address": "789 Maple St",
        "phoneNumber": "7890123456",
        "email": "michelle@example.com"
    },
    {
        "uniqueCode": "YZA567",
        "name": "Daniel",
        "lastName": "Brown",
        "dni": "34567890",
        "age": 31,
        "address": "987 Pine St",
        "phoneNumber": "8901234567",
        "email": "daniel@example.com"
    },
    {
        "uniqueCode": "BCD890",
        "name": "Amanda",
        "lastName": "Wilson",
        "dni": "01234567",
        "age": 29,
        "address": "654 Cedar St",
        "phoneNumber": "9012345678",
        "email": "amanda@example.com"
    },
    {
        "uniqueCode": "EFG123",
        "name": "Jessica",
        "lastName": "Taylor",
        "dni": "78901234",
        "age": 38,
        "address": "321 Birch St",
        "phoneNumber": "0123456789",
        "email": "jessica@example.com"
    },
    {
        "uniqueCode": "HIJ456",
        "name": "Andrew",
        "lastName": "King",
        "dni": "23456789",
        "age": 32,
        "address": "456 Walnut St",
        "phoneNumber": "1234567890",
        "email": "andrew@example.com"
    },
    {
        "uniqueCode": "KLM789",
        "name": "Stephanie",
        "lastName": "Lee",
        "dni": "90123456",
        "age": 39,
        "address": "789 Maple St",
        "phoneNumber": "2345678901",
        "email": "stephanie@example.com"
    },
    {
        "uniqueCode": "NOP012",
        "name": "Jason",
        "lastName": "Wong",
        "dni": "34567890",
        "age": 36,
        "address": "987 Pine St",
        "phoneNumber": "3456789012",
        "email": "jason@example.com"
    },
    {
        "uniqueCode": "QRS345",
        "name": "Rachel",
        "lastName": "Nguyen",
        "dni": "01234567",
        "age": 26,
        "address": "654 Cedar St",
        "phoneNumber": "4567890123",
        "email": "rachel@example.com"
    }
]
);