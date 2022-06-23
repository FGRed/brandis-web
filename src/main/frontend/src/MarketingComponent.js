import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Table} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import "./Table.css"

export default function MerchantComponent(){

    var selectedElements = []

    const waysOfMarketing = [
        {name:"TV",  price:1000.0},
        {name:"Internet", price:1500.0},
        {name:"Phone", price:2000.0}]
    const mark = waysOfMarketing.map((marketing) =>
        <tr>
            <td><div suppressContentEditableWarning={true}
                     onBlur={(event)=>focusLost(event)}
                     onClick={(event)=>changeComponent(event)}>{marketing.name}</div></td>
            <td><div suppressContentEditableWarning={true}
                     onBlur={(event)=>focusLost(event)}
                     onClick={(event)=>changeComponent(event)}>{marketing.price}</div></td>
        </tr>
    );

    const changeComponent=(event)=>{
        let div = event.target
        if(event.detail === 1){
            let div = event.currentTarget
            let td = div.parentElement.parentElement
            console.log(td)
            if(!td.classList.contains("bg-primary")) {
                td.classList.add("bg-primary")
                selectedElements.push(td)
            }else{
                td.classList.remove("bg-primary")
                selectedElements = selectedElements.filter((item)=>{
                    return item !== td;
                });
            }
        }else if(event.detail === 2){

            div.setAttribute("contenteditable", "true")
            div.focus();
        }
    }

    const focusLost=(event)=>{
        let div = event.target
        div.setAttribute("contenteditable", "false");
        console.log("Focus lost")
        //Do Save
    }

    const removeSelected=()=>{
        selectedElements.forEach(element=>{
            element.remove()
        })
        //Remove elements post
        selectedElements = []
    }

    const buy=()=>{
        let marketingSel = document.querySelector("#marketingSelect")
        let marketingOpt = marketingSel.options[marketingSel.selectedIndex]
        let marketing = marketingOpt.text
        let priceSel = document.querySelector("#priceSelect")
        let priceOpt = priceSel.options[priceSel.selectedIndex]
        let price = priceOpt.text

        let table = document.querySelector("#marketingTable").getElementsByTagName('tbody')[0]
        let row = table.insertRow(-1)
        let cell = row.insertCell(0)
        let cell2 = row.insertCell(1)

        let nameText = document.createTextNode(marketing)
        let priceText = document.createTextNode(price)



        cell.appendChild(nameText)
        cell2.appendChild(priceText)

        marketingOpt.remove()

        //Do buy
    }



    return(
        <>
            <Row>
                <Col><h6>Buy marketing</h6></Col>
            </Row>
            <Row className="mb-2">
                <Col className="col-lg-8"><span>Marketing</span></Col>
                <Col><span>Price</span></Col>
            </Row>
            <Row>
                <Col className="col-lg-8">
                    <select className="form-select" aria-label="Default select example" id="marketingSelect">
                        <option value="1">TV</option>
                        <option value="2">Internet</option>
                        <option value="3">Phone</option>
                    </select>
                </Col>
                <Col className="col">
                    <select className="form-select" aria-label="Default select example" id="priceSelect">
                        <option value="1">500;-</option>
                        <option value="2">1000;-</option>
                        <option value="1">1500;-</option>
                        <option value="2">2000;-</option>
                        <option value="1">2500;-</option>
                        <option value="2">3000;-</option>
                        <option value="1">3500;-</option>
                        <option value="2">4000;-</option>
                        <option value="2">4500;-</option>
                        <option value="2">5000;-</option>
                    </select>
                </Col>
            </Row>
            <Row>
                <Col><Button className="mt-2 me-1" style={{float:"right"}} onClick={()=>buy()}>Buy</Button></Col>
            </Row>
            <Row className="my-1">
                <Col><h6>Marketing</h6></Col>
            </Row>
            <div className="table-wrapper w-100">
                <Table bordered hover striped size="sm" id="marketingTable">
                    <thead>
                    <tr>
                        <th>Marketing</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    {mark}
                    </tbody>
                </Table>
            </div>
            <Row>
                <Col className="mt-2 me-1">
                    <Button onClick={()=>removeSelected()} style={{float:"right"}}>
                        Remove
                        <i className="fa-solid fa-circle-minus ms-2"></i>
                    </Button>
                </Col>
            </Row>
        </>

    )


}