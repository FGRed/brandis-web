import React from "react"
import Modal from "react-bootstrap/Modal";
import {Form} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import FormRange from "react-bootstrap/FormRange";
import Button from "react-bootstrap/Button";
import axios from "axios";

export default function LoanModal(props){

    const [loanSum, setLoanSum] = React.useState(0);

    const close = () => {
        setLoanSum(0);
        props.onHide();

    };
    const handleSubmit =()=>{
        const form = new FormData(document.querySelector("#transferForm"))

        axios.post("/transfer-funds/",
            form).then((response)=>{
            props.changeState();
            setLoanSum(0);
            props.onHide();

        });
    }
    
    return(
        <>
        <Modal
            onHide={props.onHide}
            show={props.show}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Pay loan
                </Modal.Title>
            </Modal.Header>
            <Form id="transferForm">
                <Modal.Body>
                    <Row>
                        <Col><h6>{"Company Funds: " + (props.funds - loanSum) + ",-"}</h6></Col>
                        <input type="hidden" name="funder" value={props.funds - loanSum}/>
                        <Col className="col-6"><FormRange min={0} value={loanSum} max={props.loan} onChange={()=>setLoanSum(document.querySelector("#range").value)} id="range"></FormRange></Col>
                        <input type="hidden" name="receiver" value={props.loan - loanSum}/>
                        <Col><h6>{"Loan: " + (props.loan - loanSum) + ",-"}</h6></Col>
                        <input type="hidden" name="method" value="loan"/>
                    </Row>
                </Modal.Body>
                <Modal.Footer>
                    <Button onClick={()=>close()}>Cancel</Button>
                    <Button variant="primary" onClick={handleSubmit}>
                        Confirm
                    </Button>
                </Modal.Footer>
            </Form>
        </Modal>
        </>    
    )
    
}