import "./featured.scss";
import Chart from 'react-apexcharts'
import React, {Component} from 'react';

class Likmine extends Component {
  constructor(props) {
    super(props);

    this.state = {
    
      series: [
        {
          name: 'Actual',
          data: [
            {
              x: 'Jan',
              y: 2500,
              goals: [
                {
                  name: 'Expected',
                  value: 3000,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Feb',
              y: 4432,
              goals: [
                {
                  name: 'Expected',
                  value: 5400,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Mar',
              y: 5423,
              goals: [
                {
                  name: 'Expected',
                  value: 5200,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'April',
              y: 6653,
              goals: [
                {
                  name: 'Expected',
                  value: 6500,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'May',
              y: 5000,
              goals: [
                {
                  name: 'Expected',
                  value: 6500,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Jun',
              y: 6300,
              goals: [
                {
                  name: 'Expected',
                  value: 7000,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'July',
              y: 4500,
              goals: [
                {
                  name: 'Expected',
                  value: 5400,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Aug',
              y: 6553,
              goals: [
                {
                  name: 'Expected',
                  value: 7300,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Sep',
              y: 4553,
              goals: [
                {
                  name: 'Expected',
                  value: 5300,
                  strokeHeight: 3,
                 // strokeDashArray: 2,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Oct',
              y: 4700,
              goals: [
                {
                  name: 'Expected',
                  value: 5500,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Nov',
              y: 6553,
              goals: [
                {
                  name: 'Expected',
                  value: 7000,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            },
            {
              x: 'Dec',
              y: 3053,
              goals: [
                {
                  name: 'Expected',
                  value: 4200,
                  strokeHeight: 3,
                  strokeColor: '#775DD0'
                }
              ]
            }
          ]
        }
      ],
      options: {
        chart: {
          height: 100,
          type: 'bar'
        },
        plotOptions: {
          bar: {
            columnWidth: '40%'
          }
        },
        colors: ['#00E396'],
        dataLabels: {
          enabled: false
        },
        legend: {
          show: true,
          showForSingleSeries: true,
          customLegendItems: ['Actual ', 'Expected'],
          markers: {
            fillColors: ['#00E396', '#775DD0']
          }
        }
      },
    
    
    };
  }



  render() {
    return (
      
<div id="featuredChart">

<Chart options={this.state.options} series={this.state.series} type="bar" height={400} width = {"100%"} />
</div>
        );
      }
    }
    

const Featured = () => {
  return (
    <div className="featured">
      <div className="top">
        <h1 className="title">Price History</h1>
      </div>
      <div className="bottom">
        <div className="featuredChart">
     
          <Likmine  width="100%"/>
        </div>
       
        
  
           
            
            </div>
          </div>
       
      
   
  );
};

export default Featured;


