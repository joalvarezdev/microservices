CREATE TABLE IF NOT EXISTS details (
    id SERIAL NOT NULL,
    sku VARCHAR(50) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    order_id UUID NOT NULL,
    CONSTRAINT "pk_details" PRIMARY KEY (id),
    CONSTRAINT "fk_details" FOREIGN KEY (order_id) REFERENCES orders(id)
);