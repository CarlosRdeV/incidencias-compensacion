CREATE TABLE sequence_table (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                sequence_name VARCHAR(255) NOT NULL,
                                next_val BIGINT NOT NULL
);

INSERT INTO sequence_table (sequence_name, next_val) VALUES ('empleado_sequence', 65000001);
