import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import React from "react";

export default function Stats(){
    return (
        <>
            <Row className="w-100 mb-2">
                <Col><h3>Stats</h3></Col>
            </Row>
            <Row style={{height:"800px"}} className="mx-1 border">
                <Col className="w-100 border-end">
                    <Row className="w-100 mt-4">
                        <Col className="text-center">Whole year</Col>
                    </Row>
                </Col>
                <Col className="w-100">
                    <Row className="w-100 mt-4">
                        <Col className="text-center">This month</Col>
                    </Row>
                </Col>
            </Row>
        </>
    )
}