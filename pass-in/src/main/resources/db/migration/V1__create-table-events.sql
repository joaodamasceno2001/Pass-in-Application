CREATE TABLE events (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    tittle VARCHAR(255) NOT NULL,
    details VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    maximum_attendees INTEGER NOT NULL
);