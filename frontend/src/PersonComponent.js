import React from 'react'
import APIService from '../src/APIService'

export default class PersonComponent extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
             persons: []
        }
    }

    componentDidMount(){
        APIService.getAll().then((data) => {
            this.setState({ persons: data })
            console.log(this.state.data)
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });;
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Person List</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Person ID</th>
                            <th>Person First Name</th>
                            <th>Person Last Name</th>
                            <th>Person E-mail</th>
                            <th>Person Phone Number</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.persons.map(person =>
                                    <tr key={person.id}>
                                        <td>{person.id}</td>
                                        <td>{person.firstName}</td>
                                        <td>{person.lastName}</td>
                                        <td>{person.email}</td>
                                        <td>{person.phoneNumber}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

