import Home from "./Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./style/dark.scss";
import { useContext } from "react";
import { DarkModeContext } from "./darkModeContext";
import Login from "./Login";
import ReputationScore from "./ReputationScore";
import LookUp from "./LookUp";
import Purchase from "./Purchase";
import Price from "./Price";
import StakeHolder from "./StakeHolder";

function App() {
  const { darkMode } = useContext(DarkModeContext);

  return (
    <div className={darkMode ? "app dark" : "app"}>
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<Home />} />
          </Route>
          <Route path="/Login">
            <Route index element={<Login />} />
          </Route>
          <Route path="/ReputationScore">
            <Route index element={<ReputationScore />} />
          </Route>
          <Route path="/LookUp">
            <Route index element={<LookUp />} />
          </Route>
          <Route path="/Purchase">
            <Route index element={<Purchase />} />
          </Route>
          <Route path="/price">
            <Route index element={<Price />} />
          </Route>
          <Route path="/StakeHolder">
            <Route index element={<StakeHolder />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
