import "./widget.scss";
import HeatMap from "./HeatMap";
import Trend from "./Trend"
import Ico from "./Ico";


const Widget = ({ type }) => {
  
  let data;

  switch (type) {
    case "Market":
      data = {
        title: "Market Overview",
        green : <HeatMap />
       
      };

      break;
    case "trend":
      data = {
        title: "market Trend",
        trendd :  <Trend/>
    
        
    
      };
  
      break;
    case "ICO":
      data = {
        title: "Initial Coin offering",
        ico: <Ico/>
  
    
      };
      break;
    default:
      break;
  }

  return (
    <div className="widget">
      <div className="left">
      <div className="title">{data.title}</div>
      {data.green}
      {data.trendd}
      {data.ico}
        
        
      
        
        <div>
        </div>
  <div>

  </div>
    
      </div>
      <div className="right">
        <div className="percentage positive">
  
        </div>
        {data.icon}
      </div>
    </div>
  );
};

export default Widget;
