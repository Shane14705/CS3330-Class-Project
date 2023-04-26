
-- Use MemberType to determine what subclass of Member to cast the blob to when deserializing
CREATE TABLE MEMBERS (
                         MemberID INTEGER,
                         Name TEXT,
                         MemberType TEXT,
                         MemberData BLOB,
                         PRIMARY KEY (MemberID)
);

-- Use EmployeeType to determine what subclass of Employee to cast the blob to when deserializing
CREATE TABLE EMPLOYEES (
    EmployeeID INTEGER,
    Name TEXT,
    EmployeeType TEXT,
    EmployeeData BLOB,
    PRIMARY KEY (EmployeeID)
);

-- Use ItemType to determine what subclass of LibraryItem to cast the blob to when deserializing
CREATE TABLE ITEMS (
                       ItemID CHARACTER(6),
                       Title TEXT,
                       Section TEXT,
                       ItemType TEXT,
                       ItemData BLOB,
                       PRIMARY KEY (ItemID)
);

-- CREATE TABLE LOANS (
--     BorrowerId INTEGER,
--     ItemId  CHARACTER(6),
--     BLOB
--     PRIMARY KEY(BorrowerId, ItemId),
--
--
-- )