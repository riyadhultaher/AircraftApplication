import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CreateAircraftType from "./components/CreateAircraftType"
import CreateAircraft from "./components/CreateAircraft"
import UpdateAircraft from "./components/UpdateAircraft";
import UpdateAircraftType from "./components/UpdateAircraftType";
import Home from "./components/Home";

function App() {
  return (
    <div className="Aircraft App">
      <Router>
        <Routes>
          <Route exact path="/" element={<div><Home/></div>} />
          <Route path="/createAircraft" element={<div><CreateAircraft/></div>} />
          <Route path="/createAircraftType" element={<div><CreateAircraftType/></div>} />
          <Route path="/updateAircraft/:identifier" element={<div><UpdateAircraft/></div>} />
          <Route exact path="/updateAircraftType/:identifier" element={<div><UpdateAircraftType/></div>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;