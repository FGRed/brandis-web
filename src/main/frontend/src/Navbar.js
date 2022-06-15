import React from "react";
import "./Navbar.css"
import Menu from "./Menu";
import CompanyInfo from "./CompanyInfo";


class Navbar extends React.Component{
    render() { return(
        <header>
            <nav className="navbar navbar-expand-lg navbar-dark bg-light shadow">
                <div className="navbar-brand flex-grow-1 d-flex">
                    <Menu/>
                </div>
                <div className="flex-grow-1 d-flex">
                    <div className="flex-nowrap bg-light mx-0 mx-lg-auto rounded p-1">
                        <CompanyInfo/>
                    </div>
                </div>
                <button className="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div className="navbar-nav ml-auto">
                        <a className="nav-item nav-link" href="#">Twitter</a>
                        <a className="nav-item nav-link" href="#">Resume</a>
                        <a className="nav-item nav-link" href="#">Blog</a>
                    </div>
                </div>
            </nav>
        </header>
    )
    }
}

export default Navbar