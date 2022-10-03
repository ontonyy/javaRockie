import React, {Component} from "react";
import UserService from "../service/UserService";

class UserComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
    }

    componentDidMount() {
        UserService.getUsers().then(
            (response) => {
                this.setState({users: response.data})
            }
        )
    }

    render() {
        return (
            <div>
                <h1>Users List:</h1>
                <table>
                    <thead>
                        <tr>
                            <td>User ID</td>
                            <td>User name</td>
                            <td>User email</td>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.users.map(
                            user =>
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.name}</td>
                                    <td>{user.email}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserComponent;
