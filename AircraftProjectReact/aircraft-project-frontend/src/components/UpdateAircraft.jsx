import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function UpdateAircraft() {

    let navigate = useNavigate();
    const { identifier } = useParams();

    const [aircraft, setAircraft] = useState({
        serialNumber: "",
        id: "",
        missionCapability: "",
        location: "",
        flightHours: "",
        type: "",
    });

    const { serialNumber, id, missionCapability, location, flightHours, type  } = aircraft;

    const onInputChange = (e) => {
        setAircraft({ ...aircraft, [e.target.name]: e.target.value });
      };

      useEffect(() => {
        retrieveAircraft();
      }, []);
    
      const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post(`http://localhost:8080/aircraftProject/updateAircraft/${identifier}`, aircraft);
        navigate("/");
      };

      const retrieveAircraft = async () => {
        const result = await axios.get(`http://localhost:8080/aircraftProject/updateAircraft/${identifier}`);
        setAircraft(result.data);
      };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Update Aircraft</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                            <label htmlFor="SerialNumber" className="form-label">
                                Serial Number
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="serialNumber"
                                value={serialNumber}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Id" className="form-label">
                                Id
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="id"
                                value={id}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="MissionCapability" className="form-label">
                                Mission Capability
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="missionCapability"
                                value={missionCapability}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Location" className="form-label">
                                Location
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="location"
                                value={location}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="FlightHours" className="form-label">
                                FlightHours
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="flightHours"
                                value={flightHours}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Type" className="form-label">
                                Type
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="type"
                                value={type}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">
                            Submit
                        </button>
                        <Link className="btn btn-outline-danger mx-2" to="/">
                            Cancel
                        </Link>
                    </form>
                </div>
            </div>
        </div>
    );
}