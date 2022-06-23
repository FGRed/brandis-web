import React from "react"
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import {Button} from "react-bootstrap";
import "./FinancesInfo.css";
import axios from "axios";
import TransferModal from "./TransferModal";
import LoanModal from "./LoanModal";

export default function FinancesInfo(props) {

    const[gameDTO, setGameDTO] = React.useState(false);
    const[show, setShow] = React.useState(false);
    const[show2, setShow2] = React.useState(false);
    const[show3, setShow3] = React.useState(false);

    React.useEffect(() => {
        getData()
    }, [])

    const getData=()=>{
        const fmode = document.querySelector("#fmode").value;
        if(fmode !== "") {
            axios.get("/get-bgame/").then((response) => {
                setGameDTO(response.data)
            })
        }else{
          setGameDTO(
              {
                    bgame:{
                        companyName: "Placeholder"

                    },
                    bsavedGame:{
                        userFunds: 10000.0,
                        companyFunds: 100000.0,
                        loanFunds: 100.0,
                  }
              }

          )

    }
}

const changeState=()=>{
    getData()
}
if(!gameDTO) return null;
return (
    <>{gameDTO.bsavedGame !== null &&
        <section className="mt-4 shadow-sm p-3 rounded-3 border finances">
            <Row className="g-0 mb-2">
                <Col className="col-auto p-1 col-sm-3 finances-input-title rounded-2">
                    <h6 className="align-middle">Your Funds</h6>
                </Col>
                <Col className="p-1 col-lg-7 finances-input">
                    <Form.Text className="align-middle" id="finances">{gameDTO.bsavedGame.userFunds},-
                        <i className="fa fa-hand-holding-dollar mt-1-5 me-2" style={{float:"right"}}></i>
                    </Form.Text>
                </Col>
                <Col className="ms-2 finances-btn">
                    <Button variant="outline-primary w-100 align-middle me-2" onClick={()=>setShow(true)}><i className="fa-solid fa-money-bill-transfer"></i></Button>
                </Col>
            </Row>
            <Row className="g-0 mb-2">
                <Col className="col-auto p-1 col-sm-3 finances-input-title rounded-2">
                    <h6 className="align-middle company-funds">Company Funds</h6>
                </Col>
                <Col className="p-1 col-lg-7 finances-input">
                    <Form.Text className="align-middle" id="funds">{gameDTO.bsavedGame.companyFunds},-
                        <i className="fa fa-sack-dollar mt-1-5 me-2" style={{float:"right"}}></i>
                    </Form.Text>
                </Col>
                <Col className="ms-2 finances-btn">
                    <Button variant="outline-primary w-100 align-middle" onClick={()=>setShow2(true)}><i className="fa-solid fa-money-bill-transfer"></i></Button>
                </Col>
            </Row>
            <Row className="g-0">
                <Col className="col-auto p-1 col-sm-3 finances-input-title rounded-2">
                    <h6 className="align-middle">Loan</h6>
                </Col>
                <Col className="p-1 col-lg-7 finances-input">
                    <Form.Text className="align-middle" id="loan">{gameDTO.bsavedGame.loanFunds},-
                        <i className="fa fa-money-check-alt mt-1-5 me-2" style={{float:"right"}}></i>
                    </Form.Text>
                </Col>
                <Col className="ms-2 finances-btn">
                    <Button variant="outline-primary w-100 align-middle" onClick={()=>setShow3(true)}><i className="fa-solid fa-money-bill-transfer"></i></Button>
                </Col>
            </Row>
            <TransferModal
                show={show}
                onHide={()=>setShow(false)}
                funds={gameDTO.bsavedGame.userFunds}
                companyFunds={gameDTO.bsavedGame.companyFunds}
                from="Your Funds"
                to="Company Funds"
                changeState={()=>changeState()}
                method="userFundsToCompany"
            />
            <TransferModal
                show={show2}
                onHide={()=>setShow2(false)}
                funds={gameDTO.bsavedGame.companyFunds}
                companyFunds={gameDTO.bsavedGame.userFunds}
                from="Company Funds"
                to="Your Funds"
                method="companyFundsToYou"
                changeState={()=>changeState()}
            />
            <LoanModal
                show={show3}
                onHide={()=>setShow3(false)}
                funds={gameDTO.bsavedGame.companyFunds}
                loan={gameDTO.bsavedGame.loanFunds}
                changeState={()=>changeState()}
            />
        </section>
    }</>
)
}


