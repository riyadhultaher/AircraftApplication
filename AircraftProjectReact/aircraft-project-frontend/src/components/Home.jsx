import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from "react-router-dom";

export default function Home() {

    const [aircrafts, setAircrafts] = useState([]);
    const [aircraftTypes, setAircraftTypes] = useState([]);

    useEffect(() => {
        loadAircrafts();
        loadAircraftTypes();
    }, []);

    const loadAircrafts = async () => {
        const result = await axios.get("http://localhost:8080/aircraftProject/retrieveAircrafts");
        setAircrafts(result.data);
    }

    const loadAircraftTypes = async () => {
        const result = await axios.get("http://localhost:8080/aircraftProject/retrieveAircraftTypes");
        setAircraftTypes(result.data);
    }

    const deleteAircraft = async (id) => {
        await axios.delete(`http://localhost:8080/aircraftProject/deleteAircraft/${id}`);
        loadAircrafts();
        loadAircraftTypes();
      };

      const deleteAircraftType = async (typeId) => {
        await axios.delete(`http://localhost:8080/aircraftProject/deleteAircraftType/${typeId}`);
        loadAircrafts();
        loadAircraftTypes();
      };

    return (
        <div className='container'>
            <h2 className="text-center">Aircraft List</h2>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Serial Number</th>
                        <th scope="col">Id</th>
                        <th scope="col">Mission Capability</th>
                        <th scope="col">Location</th>
                        <th scope="col">Flight Hours</th>
                        <th scope="col">Type</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        aircrafts.map((aircraft, id) =>
                            <tr key={aircraft.id}>
                                <td>{aircraft.serialNumber}</td>
                                <td>{aircraft.id}</td>
                                <td>{aircraft.missionCapability}</td>
                                <td>{aircraft.location}</td>
                                <td>{aircraft.flightHours}</td>
                                <td>{aircraft.type}</td>
                                <td><Link
                                    className="btn btn-outline-primary mx-2"
                                    to={`/updateAircraft/${aircraft.id}`}
                                >
                                    Edit
                                </Link>
                                    <button
                                        className="btn btn-outline-danger mx-2"
                                        onClick={() => deleteAircraft(aircraft.id)}
                                    >
                                        Delete
                                    </button></td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <div className="button" style={{ display: "flex" }}>
                <button className="btn btn-primary" style={{ marginLeft: "auto" }}><Link className="btn btn-primary" to="/createAircraft">Create Aircraft</Link></button>
            </div>
            <h2 className="text-center">Aircraft Type List</h2>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Type Id</th>
                        <th scope="col">Description</th>
                        <th scope="col">Model</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        aircraftTypes.map((aircraftType, typeId) =>
                            <tr key={aircraftType.typeId}>
                                <td>{aircraftType.typeId}</td>
                                <td>{aircraftType.description}</td>
                                <td>{aircraftType.model}</td>
                                <td><Link
                                    className="btn btn-outline-primary mx-2"
                                    to={`/updateAircraftType/${aircraftType.typeId}`}
                                >
                                    Edit
                                </Link>
                                    <button
                                        className="btn btn-outline-danger mx-2"
                                        onClick={() => deleteAircraftType(aircraftType.typeId)}
                                    >
                                        Delete
                                    </button></td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <div className="button" style={{ display: "flex" }}>
                <button className="btn btn-primary" style={{ marginLeft: "auto" }}><Link className="btn btn-primary" to="/createAircraftType">Create Aircraft Type</Link></button>
            </div>
        </div>
    )
}