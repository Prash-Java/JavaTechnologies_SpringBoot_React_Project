import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props){
        super(props);

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <footer className='footer'>
                    <span className='text-dark'>All Rights Reserved @2023 Java Development</span>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;