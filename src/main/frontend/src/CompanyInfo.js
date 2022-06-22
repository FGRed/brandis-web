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

    const [gameDTO, setGameDTO] = useState(null)
    const [style, setStyle] = useState(null)

        useEffect(() => {
            axios.get("/get-bgame/").then((response) => {
                setGameDTO(response.data)
                let bsavedGame = response.data.bsavedGame;
                if(bsavedGame !== null){
                    let percent = response.data.bsavedGame.brand + "%"
                    setStyle({width: percent})
                }
            }).catch(reason => {
                let fmode = document.querySelector("#fmode").value;
                if(!fmode){
                    setGameDTO({bgame:{companyName: "Placeholder", brand: 25.0}, bsavedGame:{brand:20.0}})
                    setStyle({width: "12%"})
                }
            });
            }, [])

    if(!gameDTO) return null;

        return (
            <div className="ml-auto w-100 ps-2" hidden={gameDTO.bgame.companyName === ""}>
                <div className="row">
                    <div className="col justify-content-start">
                        <h5 className={"text-start " + textColor}>{gameDTO.bgame.companyName}</h5>
                    </div>
                </div>
                <div className="progress ml-auto" style={{height: "12px"}}>
                    <div className="progress-bar progress-bar-striped" style={style} role="progressbar" aria-valuenow="75"  aria-valuemin="0"
                         aria-valuemax="100">{gameDTO.bsavedGame !== null && gameDTO.bsavedGame.brand + "%"}</div>
                </div>
            </div>
        );
}

export default CompanyInfo