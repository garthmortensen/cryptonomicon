import "./sidebar.scss";
import LocalShippingIcon from "@mui/icons-material/LocalShipping";
import { Link } from "react-router-dom";
import { DarkModeContext } from "./darkModeContext";
import { useContext } from "react";
import ManageSearchIcon from '@mui/icons-material/ManageSearch';
import MonetizationOnIcon from '@mui/icons-material/MonetizationOn';
import LoginIcon from '@mui/icons-material/Login';
import ScoreIcon from '@mui/icons-material/Score';
import TimelineIcon from '@mui/icons-material/Timeline';

const Sidebar = () => {
  const { dispatch } = useContext(DarkModeContext);
  return (
    <div className="sidebar">
      <div className="top">
        <Link to="/" style={{ textDecoration: "none" }}>
          <span className="logo">BetterCryptoBureau
</span>
        </Link>
      </div>
      <hr />
      <div className="center">
        <ul>

        <Link to="/Login" style={{ textDecoration: "none" }}>
            <li>
              <LoginIcon className="icon" />
              <span>Login</span>
            </li>
          </Link>

          <Link to="/ReputationScore" style={{ textDecoration: "none" }}>
            <li>
              <ScoreIcon className="icon" />
              <span>Reputation Score</span>
            </li>
          </Link>
          <Link to="/LookUp" style={{ textDecoration: "none" }}>
          <li>
            <ManageSearchIcon className="icon" />
            <span>Look up Cryptocurrency</span>
          </li>
          </Link>
          <Link to="/Purchase" style={{ textDecoration: "none" }}>
            <li>
              <MonetizationOnIcon className="icon" />
              <span>Purchase</span>
            </li>
          </Link>
          <Link to="/Price" style={{ textDecoration: "none" }}>
          <li>
            <TimelineIcon className="icon" />
            <span>Price</span>
          </li>
          </Link>
          <Link to="/StakeHolder" style={{ textDecoration: "none" }}>
          <li>
            <LocalShippingIcon className="icon" />
            <span>Score</span>
          </li>
          </Link>



        </ul>
      </div>
      <div className="bottom">
        <div
          className="colorOption"
          onClick={() => dispatch({ type: "LIGHT" })}
        ></div>
        <div
          className="colorOption"
          onClick={() => dispatch({ type: "DARK" })}
        ></div>
      </div>
    </div>
  );
};

export default Sidebar;
