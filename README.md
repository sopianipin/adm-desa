# adm-desa


# Query
CREATE TABLE penduduk (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nik VARCHAR(16),
  full_name VARCHAR(255),
  gender VARCHAR(10),
  birth_place VARCHAR(255),
  date_of_birth DATE,
  no_kk VARCHAR(16),
  address VARCHAR(255),
  marital_status VARCHAR(20),
  nationality VARCHAR(50),
  education VARCHAR(50),
  profession VARCHAR(50),
  mother_name VARCHAR(255),
  father_name VARCHAR(255),
  rt VARCHAR(5),
  rw VARCHAR(5),
  postal_code VARCHAR(10),
  village VARCHAR(255),
  sub_district VARCHAR(255),
  city VARCHAR(255),
  province VARCHAR(255),
  status VARCHAR(10)
);

CREATE TABLE program (
  id INT AUTO_INCREMENT PRIMARY KEY,
  program_name VARCHAR(255),
  details TEXT,
  active_date DATE,
  end_date DATE
);

CREATE TABLE program_details (
  id INT AUTO_INCREMENT PRIMARY KEY,
  program_id INT,
  nik VARCHAR(16),
  detail TEXT
);

CREATE TABLE village_organization (
  id INT AUTO_INCREMENT PRIMARY KEY,
  organization_name VARCHAR(255)
);

CREATE TABLE village_organization_detail (
  id INT AUTO_INCREMENT PRIMARY KEY,
  organization_id INT,
  nik VARCHAR(16),
  position VARCHAR(50),
  status VARCHAR(10)
);
