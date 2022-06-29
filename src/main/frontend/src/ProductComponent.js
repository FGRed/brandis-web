import React from "react"
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Table} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import "./Table.css"
import ReactDOM from "react-dom/client";
import NewPriceCol from "./NewPriceCol";

export default function ProductComponent(){

    var selectedElements = []

    const[sum, setSum] = React.useState(0.0)

    const breads = [
        {name:"Bread1",  price:"1,-", sellingPrice:1.50,amount:10000},
        {name:"Bread2",  price:"1,-", sellingPrice:1.50,amount:10000},
        {name:"Bread3",  price:"1,-", sellingPrice:1.50,amount:10000},
        {name:"Bread4",  price:"1,-", sellingPrice:1.50,amount:10000},]
    const breadElems = breads.map((bread) =>
        <tr>
            <td><div>{bread.name}</div></td>
            <td><div>{bread.price}</div></td>
            <td><NewPriceCol sellingPrice={bread.sellingPrice}/></td>
            <td><div>{bread.amount}</div></td>
            <td><div suppressContentEditableWarning={true}>6/29/2022</div></td>
            <td style={{textAlign:"center"}}>
                <input className="form-check-input" type="checkbox"/>
            </td>
        </tr>
    );




    const showChangePriceEditor=(event, sellingPrice)=>{
        if(event.detail === 2) {
            let div = event.target
            let input = document.createElement('<input ' +
                'class="form-control form-control-sm col-lg-2" ' +
                'type="number" ' +
                'min="0" ' +
                'step="0.5" ' +
                'max="1000"' +
                'value=' + sellingPrice +
                '/>')
            div.innerHTML = ''
            div.append(input)

            input.focus()
        }
    }

    const hideChangePriceEditor=(event)=>{
        let div = event.target.parentElement
        div.innerHTML = event.target.value
    }



    const purchase=()=>{
        const productSel = document.querySelector("#productSel")
        const productName = productSel.options[productSel.selectedIndex].text
        const productPrice = document.querySelector("#price").innerHTML
        const sellingPrice = productPrice
        const amount = document.querySelector("#amount").value

        let table = document.querySelector("#productTable").getElementsByTagName('tbody')[0]
        let div = ReactDOM.createRoot(table)
        div.render(<div>Test</div>)

    }


    const removeSelected=()=>{
        selectedElements.forEach(element=>{
            element.remove()
        })
        //Remove elements post
        selectedElements = []
    }

    const inputPrice=(event)=>{
        let productSel = event.target
        let priceElem = document.querySelector("#price")
        let newPrice = productSel.options[productSel.selectedIndex].getAttribute("name")
        const amount = document.querySelector("#amount").value
        priceElem .innerHTML = newPrice
        console.log(newPrice + " " + amount)
        setSum(newPrice.replace(";-", "") * amount)

    }

    const amountTyped=(event)=>{
        let amount = event.target.value
        let newPrice = document.querySelector("#price").innerHTML
        setSum(newPrice.replace(";-", "") * amount)
    }

    return(
        <>
            <Row>
                <Col><h6>Purchase Product Batch</h6></Col>
            </Row>
            <Row className="mb-2 g-2">
                <Col className="col-lg-6"><span>Item</span></Col>
                <Col className="col-auto"><span>Unit price</span></Col>
                <Col className="col-auto ms-1"><span>Amount</span></Col>
            </Row>
            <Row>
                <Col className="col-lg-6">
                    <select className="form-select" aria-label="Default select example" id="productSel" onChange={(event)=>inputPrice(event)}>
                        <option name="1.0;-" value="1">Rye bread</option>
                        <option name="1.5;-" value="2">Crisp bread</option>
                    </select>
                </Col>
                <Col className="pt-2 col-sm-2">
                    <span id="price">1.00;-</span>
                </Col>
                <Col className="col-sm-4">
                    <input className="form-control" type="number" min="0" max="10000" step="100" placeholder="Amount" onChange={(event)=>amountTyped(event)} id="amount"/>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col className="pt-2">Total: {sum};-</Col>
                <Col><Button className="me-1" style={{float:"right"}} onClick={()=>purchase()} >Purchase</Button></Col>
            </Row>
            <Row className="my-1">
                <Col><h6>Store</h6></Col>
            </Row>
            <div className="table-wrapper w-100">
                <Table bordered hover striped size="sm" id="productTable">
                    <thead>
                    <tr>
                        <th>Product</th>
                        <th>Price</th>
                        <th>New price</th>
                        <th>In stock</th>
                        <th>Exp. date</th>
                        <td style={{textAlign:"center"}}>
                            <input className="form-check-input" type="checkbox"/>
                        </td>
                    </tr>
                    </thead>
                    <tbody id="productTable-Tbody">
                    {breadElems}
                    </tbody>
                </Table>
            </div>
            <Row>
                <Col className="mt-2 me-1">
                    <Button onClick={()=>removeSelected()} style={{float:"right"}}>
                        Return
                        <i className="fa-solid fa-hand-point-right ms-2"></i>
                    </Button>
                </Col>
            </Row>
        </>

    )
}