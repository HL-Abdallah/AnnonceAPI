CREATE TABLE annonce (
    id UUID PRIMARY KEY,
    titre VARCHAR(255),
    description VARCHAR(255),
    prix float,
    type VARCHAR(50) CHECK (type IN ('IMMOBILIER', 'VEHICULE', 'EMPLOI'))
);