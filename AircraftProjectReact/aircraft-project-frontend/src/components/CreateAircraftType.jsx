import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function CreateAircraftType() {

    let navigate = useNavigate();

    const [aircraftType, setAircraftType] = useState({
        typeId: "",
        description: "",
        model: ""
    });

    const { typeId, description, model } = aircraftType;

    const onInputChange = (e) => {
        setAircraftType({ ...aircraftType, [e.target.name]: e.target.value });
      };
    
      const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/aircraftProject/createAircraftType", aircraftType);
        navigate("/");
      };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Create Aircraft Type</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                            <label htmlFor="TypeId" className="form-label">
                                TypeId
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="typeId"
                                value={typeId}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Description" className="form-label">
                                Description
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="description"
                                value={description}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Model" className="form-label">
                                Model
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                name="model"
                                value={model}
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