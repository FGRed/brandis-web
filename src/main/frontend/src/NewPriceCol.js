import React from "react"
import "./NewPriceCol.css"

export default function NewPriceCol({sellingPrice}){

    const [colItem, setColItem] =  React.useState(sellingPrice)
    const [value, setValue] = React.useState(sellingPrice)

    const showChangePriceEditor=(event)=>{
        if(event.detail === 2) {
           setColItem(<input autoFocus onBlur={(event)=>hideChangePriceEditor(event)} className="form-control form-control-xs"
                              type="number" min="0" step="0.1" max="1000" defaultValue={value}/>)

        }
    }

    const hideChangePriceEditor=(event)=>{
        setColItem(event.target.value+",-")
        setValue(event.target.value)
    }

    return (<div onClick={(event)=>showChangePriceEditor(event)}>
        {colItem}
    </div>)
}