import React from "react";
import MerchantComponent from "./MerchantComponent";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

export default function Game(){
    return(
        <>
            <Row className="shadow-sm px-2 py-3 my-3 mx-1 border">
                <Col><MerchantComponent/></Col>
                <Col><MerchantComponent/></Col>
            </Row>
        </>
    )
}