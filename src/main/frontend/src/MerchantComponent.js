import Row from "react-bootstrap/Row"
import React, {useState} from "react"
import Col from "react-bootstrap/Col";
import {Table} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import "./Table.css"
import axios from "axios";

export default function MerchantComponent(){

    const [emplS, setEmpls] = useState(null);
    const [selectedRows, setSelectedRows] = useState([])
    const [availableEmployee, setAvailableEmployee] = useState([])
    const [monthlySalaryExpenses, setMonthlySalaryExpenses]  = useState(0.0)

    React.useEffect(() => {
        getData()
    }, [])

    const getData=()=>{
        const fmode = document.querySelector("#fmode").value;

        if(fmode !== "") {
            axios.get("/employee/current-employees/").then((response) => {
                setMonthlySalaryExpenses(response.data.salaryExpense)
                setEmpls(response.data.hiredEmployees.map((hiredEmployee) =>
                    <tr id={hiredEmployee.id}>
                        <td>
                            <div suppressContentEditableWarning={true}
                                 onClick={(event)=>handleClick(event)}>{hiredEmployee.employee.name}</div>
                        </td>
                        <td>
                            <div suppressContentEditableWarning={true}
                                 onBlur={(event)=>focusLost(event)}
                                 onClick={(event)=>changeComponent(event)}>{hiredEmployee.salary};-
                        </div>
                        </td>
                        <td style={{textAlign:"center"}}>
                            <input className="form-check-input" type="checkbox"/>
                        </td>
                    </tr>
                ))
                setAvailableEmployee(response.data.availableEmployees.map((employee) =>
                    <option id={employee.id}>{employee.name}</option>
                ))
            }
            )
        }
    }




    const changeComponent=(event)=>{
        let div = event.target
        if(event.detail === 1) {
            let div = event.currentTarget
            let td = div.parentElement.parentElement
            if(!td.classList.contains("bg-primary")) {
                td.classList.add("bg-primary")
                selectedRows.push(td)
            }else{
                td.classList.remove("bg-primary")
                setSelectedRows(selectedRows.filter((item)=>{
                    return item !== td;
                }))
            }
        }else if(event.detail === 2){
            let salary = div.innerHTML
            div.innerHTML = ''
            div.insertAdjacentHTML(
                'beforeend',
                '<select id = "employeeSelTable" class="w-100">' +
                '<option value="500">500;-</option>' +
                '<option value="1000">1000;-</option>' +
                '<option value="1500">1500;-</option>' +
                '<option value="2000">2000;-</option>' +
                '<option value="2500">2500;-</option>' +
                '<option value="3000">3000;-</option>' +
                '<option value="3500">3500;-</option>' +
                '<option value="4000">4000;-</option>' +
                '<option value="4500">4500;-</option>' +
                '<option value="5000">5000;-</option>' +
            '</select>')

            document.querySelector("#employeeSelTable").value = salary

            div.focus();
        }
    }

    const handleClick=(event)=>{
        if(event.detail === 1) {
            let div = event.currentTarget
            let td = div.parentElement.parentElement
            if(!td.classList.contains("bg-primary")) {
                td.classList.add("bg-primary")
                selectedRows.push(td)
            }else{
                td.classList.remove("bg-primary")
                setSelectedRows(selectedRows.filter((item)=>{
                    return item !== td;
                }))
            }
        }
    }

    const focusLost=(event)=>{
        let div = event.target.parentElement
        const id = div.parentElement.parentElement.id
        const select = document.querySelector("#employeeSelTable")
        const salary = select.options[select.selectedIndex].value

        axios.post("/employee/change-salary/",
            {
                id : id,
                salary: salary
            },
            {
                headers:
                    {"content-type" : "application/json"}
            }
        ).then(()=>{
            getData()
            div.innerHTML = salary + ';-'
        });

    }

    const selectAll=(event)=>{
        const checked = event.target.checked
        document.querySelector("#employeeTable").querySelectorAll(".form-check-input").forEach((cb)=>{
                cb.checked = checked
        })

    }

    const fireSelected=()=>{
        let formData = new FormData();
        document.querySelector("#employeeTable").querySelector("tbody").querySelectorAll('input[type="checkbox"]:checked').forEach(cb => {
            formData.append("employeeRow", cb.parentElement.parentElement.id);
        })

        axios.post("/employee/fire-employees/",
                formData,
            {
                headers:
                    {"content-type" : "multipart/form-data"}
            }
        ).then((response)=>{
            console.log(response)
            if(response.status === 200){
                getData();
                document.querySelector("#selectAll").checked = false

            }else if(response.status === 400){
                alert("400 Bad Request.")
            }else{
                alert("Unexpected error")
            }
        })

        getData();

    }

    const hire=()=>{
        let employeeSel = document.querySelector("#employeeSelect")
        let employeeOpt = employeeSel.options[employeeSel.selectedIndex]
        let salarySel = document.querySelector("#salarySelect")
        let salarySelOpt = salarySel.options[salarySel.selectedIndex]

        axios.post("/employee/hire-employee/",
            {
                id : employeeOpt.getAttribute("id"),
                name: employeeOpt.text,
                salary: salarySelOpt.value
            }
        ).then(()=>{
            getData()
        });
    }

    return(
        <>
            <Row>
                <Col><h6>Hire a Merchant</h6></Col>
            </Row>
            <Row className="mb-2">
                <Col className="col-lg-8"><span>Merchant</span></Col>
                <Col><span>Salary</span></Col>
            </Row>
            <Row>
                <Col className="col-lg-8">
                    <select className="form-select" aria-label="Default select example" id="employeeSelect">
                        {availableEmployee}
                    </select>
                </Col>
                <Col className="col">
                    <select className="form-select" aria-label="Default select example" id="salarySelect">
                        <option value="500.0">500;-</option>
                        <option value="1000.0">1000;-</option>
                        <option value="1500.0">1500;-</option>
                        <option value="2000.0">2000;-</option>
                        <option value="2500.0">2500;-</option>
                        <option value="3000.0">3000;-</option>
                        <option value="3500.0">3500;-</option>
                        <option value="4000.0">4000;-</option>
                        <option value="4500.0">4500;-</option>
                        <option value="5000.0">5000;-</option>
                    </select>
                </Col>
            </Row>
            <Row>
                <Col><Button className="mt-2 me-1" style={{float:"right"}} onClick={()=>hire()}>Hire</Button></Col>
            </Row>
            <Row className="my-1">
                <Col><h6>Hired Employees</h6></Col>
            </Row>
            <div className="table-wrapper w-100 border">
                <Table bordered hover striped size="sm" id="employeeTable">
                    <thead>
                    <tr>
                        <th>Employee</th>
                        <th>Salary</th>
                        <th style={{textAlign:"center"}}>
                            <input id="selectAll" onClick={(event)=>selectAll(event)} className="form-check-input row-cb" type="checkbox"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {emplS}
                    </tbody>
                </Table>
            </div>
            <Row>
                <Col className="mt-2 me-1">
                    <p>Monthly expenses: {monthlySalaryExpenses};-</p>
                </Col>
                <Col className="mt-2 me-1">
                    <Button onClick={fireSelected} style={{float:"right"}}>
                        Fire
                        <i className="fa-solid fa-hand-point-right ms-2"></i>
                    </Button>
                </Col>
            </Row>
        </>

    )


}