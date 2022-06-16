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
        <nav className="navbar navbar-expand navbar-light bg-light shadow mx-2" id="b--navbar">
            <div className="d-flex w-100">
                <Menu userLoggedIn={this.props.userLoggedIn}/>
                <div className="navbar-collapse">
                    <div className="navbar-nav mx-auto justify-content-center w-75">
                            <CompanyInfo userLoggedIn={this.props.userLoggedIn}/>
                    </div>
                    <div className="nav-login">
                        <NavLogin userLoggedIn={this.props.userLoggedIn}/>
                    </div>

                </div>
            </div>
        </nav>
    )
    }
}
export default Navbar