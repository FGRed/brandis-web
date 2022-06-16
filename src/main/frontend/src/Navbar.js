import React from "react";
import "./Navbar.css"
import Menu from "./Menu";
import CompanyInfo from "./CompanyInfo";
import NavLogin from "./NavLogin";


class Navbar extends React.Component{

    constructor(props) {
        super(props);
    }

    render() { return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light shadow">
            <div className="container-fluid">
                <Menu userLoggedIn={this.props.userLoggedIn}/>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mx-auto mb-2 mb-lg-0 justify-content-center">
                        <li className="nav-item">
                            <CompanyInfo userLoggedIn={this.props.userLoggedIn}/>
                        </li>
                    </ul>
                    <div className="d-flex">
                        <NavLogin userLoggedIn={this.props.userLoggedIn}/>
                    </div>
                </div>
            </div>
        </nav>
    )
    }
}

export default Navbar