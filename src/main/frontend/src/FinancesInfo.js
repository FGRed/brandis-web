import React from "react"
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import {Button} from "react-bootstrap";
import "./FinancesInfo.css";

export default function FinancesInfo(props) {

    return (
        <section className="w-100 mt-4 shadow border p-3 rounded-3">
        <Row className="g-0 mb-2">
            <Col className="col-auto p-1 col-sm-2 finances-input-title">
                <h6 className="align-middle">Your Funds</h6>
            </Col>
            <Col className="border border-secondary p-1 col-lg-8">
                <Form.Text className="align-middle" id="finances">100000€</Form.Text>
            </Col>
            <Col className="ms-2 finances-btn">
                <Button variant="outline-primary w-100">Paycheck time</Button>
            </Col>
        </Row>
        <Row className="g-0 mb-2">
            <Col className="col-auto p-1 col-sm-2 finances-input-title">
                <h6  className="align-middle">Company Funds</h6>
            </Col>
            <Col className="border border-secondary p-1 col-lg-8">
                <Form.Text className="align-middle" id="funds">100000€</Form.Text>
            </Col>
            <Col className="ms-2 finances-btn">
                <Button variant="outline-primary w-100">Transfer funds</Button>
            </Col>
        </Row>
            <Row className="g-0">
                <Col className="col-auto p-1 col-sm-2 finances-input-title">
                    <h6 className="align-middle">Loan</h6>
                </Col>
                <Col className="border border-secondary p-1 col-lg-8">
                    <Form.Text className="align-middle" id="loan">5000000000€</Form.Text>
                </Col>
                <Col className="ms-2 finances-btn">
                    <Button variant="outline-primary w-100">Manage loan</Button>
                </Col>
            </Row>
        </section>
    )
}


