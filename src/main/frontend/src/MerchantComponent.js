import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Table} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import "./Table.css"

export default function MerchantComponent(){

    var selectedElements = []

    const employees = [
        {name:"Erkki", wage:1000.0},
        {name:"Erkki2", wage:1000.0},
        {name:"Erkki3", wage:1000.0},
        {name:"Erkki4", wage:1000.0},
        {name:"Erkki5", wage:1000.0}]
    const empl = employees.map((employee) =>
        <tr>
            <td><div suppressContentEditableWarning={true}
                     onBlur={(event)=>focusLost(event)}
                     onClick={(event)=>changeComponent(event)}>{employee.name}</div></td>
            <td><div suppressContentEditableWarning={true}
                     onBlur={(event)=>focusLost(event)}
                     onClick={(event)=>changeComponent(event)}>{employee.wage}</div></td>
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

    const hire=()=>{
        let employeeSel = document.querySelector("#employeeSelect")
        let employeeOpt = employeeSel.options[employeeSel.selectedIndex]
        let employee = employeeOpt.text
        let wageSel = document.querySelector("#salarySelect")
        let wageOpt = wageSel.options[employeeSel.selectedIndex]
        let wage = wageOpt.text

        let table = document.querySelector("#employeeTable").getElementsByTagName('tbody')[0]
        let row = table.insertRow(-1)
        let cell = row.insertCell(0)
        let cell2 = row.insertCell(1)

        let nameText = document.createTextNode(employee)
        let wageText = document.createTextNode(wage)

        cell.appendChild(nameText)
        cell2.appendChild(wageText)

        employeeOpt.remove()
        wageOpt.remove()

        //Do hire
    }



    return(
        <>
            <Row>
                <Col><h6>Hire a Merchant</h6></Col>
            </Row>
            <Row className="mb-2">
                <Col className="col-lg-2"><span>Merchant</span></Col>
                <Col><span>Wage</span></Col>
            </Row>
            <Row>
                <Col className="col-lg-8">
                    <select className="form-select" aria-label="Default select example" id="employeeSelect">
                        <option defaultValue>Select merchant</option>
                        <option value="1">Tauno Jallinen</option>
                        <option value="2">Mauno Myyjä</option>
                    </select>
                </Col>
                <Col className="col">
                    <select className="form-select" aria-label="Default select example" id="salarySelect">
                        <option defaultValue>Select wage</option>
                        <option value="1">500;-</option>
                        <option value="2">1000;-</option>
                    </select>
                </Col>
            </Row>
            <Row>
                <Col><Button className="mt-2 me-1" style={{float:"right"}} onClick={()=>hire()}>Hire</Button></Col>
            </Row>
            <Row className="my-1">
                <Col><h6>Employees</h6></Col>
            </Row>
            <div className="table-wrapper w-100">
                <Table bordered hover striped size="sm" id="employeeTable">
                    <thead>
                    <tr>
                        <th>Employee</th>
                        <th>Wage</th>
                    </tr>
                    </thead>
                    <tbody>
                    {empl}
                    </tbody>
                </Table>
            </div>
            <Row>
                <Col className="mt-2 me-1"><Button onClick={()=>removeSelected()} style={{float:"right"}}>Remove</Button></Col>
            </Row>
        </>

    )


}