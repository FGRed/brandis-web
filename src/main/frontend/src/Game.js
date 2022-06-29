import React from "react";
import MerchantComponent from "./MerchantComponent";
import MarketingComponent from "./MarketingComponent";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import ProductComponent from "./ProductComponent";

export default function Game(){
    return(
            <Row className="shadow-sm p-3 mx-0 my-3 border rounded-3">
                <Col><MerchantComponent/></Col>
                <Col><ProductComponent/></Col>
            </Row>
    )
}