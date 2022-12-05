import Chart from 'react-apexcharts'
import React, {Component} from 'react';
import "./HeatMap.scss";

class ApexChart extends Component {
    constructor(props) {
      super(props);
      this.state = {
      
        series: [
          {
            data: [
    
              {
                x: 'Bullish',
                y: 90
              },
              {
                x: 'Perish',
                y: 45
              },
             
           
            
               
            ]
          }
        ],
        options: {
          legend: {
            show: false
          },
          chart: {
            height: 250,
            type: 'treemap'
          },
          
          dataLabels: {
            enabled: true,
            style: {
              fontSize: '14px',
            },
            formatter: function(text, op) {
              return [text, op.value]
            },
            offsetY: -4
          },
          plotOptions: {
            treemap: {
              enableShades: true,
              shadeIntensity: 0.5,
              reverseNegativeShade: true,
              colorScale: {
                ranges: [
                  {
                    from: 51,
                    to: 100,
                    color: '#52B12C'
                  },
                  {
                    from: 0.001,
                    to: 45,
                    color:  '#CD363A'
                  }
                ]
              }
            }
          }
        },
      
      
      };
    }

  

    render() {
      return (
        

  <div id="chart">
<Chart options={this.state.options} series={this.state.series} type="treemap"  />
</div>


      );
    }
  }
const HeatMap = () => {
    return (
      <div className="heatMap">
         <ApexChart width = {"100%"} />
          </div>
         
          
    
             
              
         
            
        
     
    );
  };
  
  export default HeatMap;