import React from "react"

class LoginForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {value: ''};
    }

    render() {return (
        <form action="/login" method="POST">
            <form className="form-floating">
                <input className="form-control" name="username" type="text" id="email"/>
                <label htmlFor="email">Email</label>
            </form>
            <form className="form-floating">
                <input className="form-control" name="password" type="text" id="password"/>
                <label htmlFor="password">Password</label>
            </form>
            <input type="submit" className="btn btn-primary" value="Log in"/>
        </form>
    )
    }

}

export default LoginForm