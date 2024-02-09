CREATE TABLE shipment_details (
	id INT UNIQUE NOT NULL,
    loading_point VARCHAR(255),
    unloading_point VARCHAR(255),
    product_type VARCHAR(255),
    truck_type VARCHAR(255),
    no_of_trucks INT,
    weight INT,
    cmts VARCHAR(255),
    shipper_id UUID,
    shipment_date DATE
);
