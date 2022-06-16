import React from "react";
import "./CompanyInfo.css";
import axios from "axios";
import {useEffect} from "react";
import {useState} from "react";

function CompanyInfo(props) {

    let textColor = '';

    if(props.userLoggedIn === 'false'){
        textColor = 'text-muted'
    }

    const [bgame, setBgame] = useState(null)
    const [style, setStyle] = useState(null)

        useEffect(() => {
            axios.get("/get-bgame/").then((response) => {
                setBgame(response.data)
                let percent = response.data.brand + "%"
                setStyle({width: percent})
            }).catch(reason => {
                let fmode = document.querySelector("#fmode").value;
                if(!fmode){
                    setBgame({companyName: "Placeholder"})
                    setStyle({width: "12%"})
                }
            });
            }, [])

    if(!bgame) return null;

        return (
            <div className="ml-auto w-100">
                <div className="row">
                    <div className="col justify-content-start">
                        <h5 className={"text-start " + textColor}>{bgame.companyName}</h5>
                    </div>
                </div>
                <div className="progress ml-auto" style={{height: "10px"}}>
                    <div className="progress-bar progress-bar-striped" style={style} role="progressbar" aria-valuenow="75"  aria-valuemin="0"
                         aria-valuemax="100"/>
                </div>
            </div>
        );
}

export default CompanyInfo