import React from "react";
import "./CompanyInfo.css";
import ReactDom from "react";
import axios from "axios";

class CompanyInfo extends React.Component{
componentDidMount() {
    axios.get(https://jsonplaceholder.typicode.com/users)
          .then(res => {
            const persons = res.data;
            this.setState({ persons });
          })
}
    return(
            <div className="ml-auto">
                <div className="row">
                    <div className="col justify-content-start">
                        <h5 className="text-start">{compName.value}</h5>
                    </div>
                </div>
                <div className="progress ml-auto">
                    <div className="progress-bar w-75" role="progressbar" aria-valuenow="75" aria-valuemin="0"
                         aria-valuemax="100"/>
                </div>
            </div>
        );
}

export default CompanyInfo