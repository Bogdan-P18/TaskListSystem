import React, { useState } from "react"
import { getUser } from "../api/userApi";
import { useNavigate } from "react-router-dom";

export interface AuthState {
    username?: string,
    password?: string
}

const initialState: AuthState = {
    username: '',
    password: ''
}

export const AuthContext = React.createContext<AuthState>(initialState);

export const LoginPage = () => {
    const [state, setState] = useState<AuthState>({});
    const { username, password } = state;
    const nav = useNavigate();
    
    const handleLogin = async () => {
        try {
            const response = await getUser(username);
            if (response.data == null) {
                console.log("Wrong username or password");
                return;
            }
            else if (response.data.password === password) {
                nav('/tasks')
            }
            else {
                console.log("Wrong password");
                return;
            }
        } catch (err) {
            console.log('Error: ' + err);
        }
    }

    return (
        <section className="container">
            <div className="header"> Sign up </div>
            <form className="inputs">
                <div className="input-around">
                    <input className="input" type="text" placeholder="Username" autoComplete="off" onChange={(e) => setState({...state, username: e.target.value})} />
                </div>

                <div className="input-around">
                    <input className="input" type="password" placeholder="Password" autoComplete="off" onChange={(e) => setState({...state, password: e.target.value})} />
                </div>

                <button className="button" type="button" onClick={handleLogin}> Sign in </button>

                <a className="text" onClick={() => {nav('/register')}}> Don't have an account? Register here! </a>
            </form>
        </section>
    );
}