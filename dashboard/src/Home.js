import Sidebar from "./Sidebar";
import "./home.scss";
import Widget from "./Widget";
import Featured from "./Featured";
import Chart from "./Chart";




const Home = () => {
  return (
    <div className="home">
      <Sidebar />
      <div className="homeContainer">
       
        <div className="widgets">
          <Widget type="Market" />

          <Widget type="trend"  />
          
          <Widget type="ICO" />
        </div>
        <div className="charts">
          <Featured />
          <Chart title="Market Sentiment" aspect={2 / 1} />
        </div>
        
      </div>
    </div>
  );
};

export default Home;
