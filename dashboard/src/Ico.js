import Chart from 'react-apexcharts'
import React, {Component} from 'react';
class ApexChart extends Component {
    constructor(props) {
      super(props);
      this.state = {
      
        series: [45, 55],
        options: {
          chart: {
            type: 'donut',
          },
          responsive: [{
            breakpoint: 480,
            options: {
              chart: {
                width: 200
              },
              legend: {
                position: 'bottom'
              }
            }
          }]
        },
      
      
      };
    }

  

    render() {
      return (
        

  <div id="chart">
<Chart options={this.state.options} series={this.state.series} type="donut" />
</div>


      );
    }
  }
  export default function Ico(){
    return( 
       <div><ApexChart/>
       </div> 
    )
  }