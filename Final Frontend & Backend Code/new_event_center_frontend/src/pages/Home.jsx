import React from "react";
import Announce from "../components/Announce";
import Slider from "../components/Slider";
import Products from "../components/Products";
import NavBar from "../components/NavBar";
import Footer from "../components/Footer";


function Home(){
    return<div>
        <Announce/>
        <NavBar/>
        <Slider/>
        <Products/>
        <Footer/>

    </div>;
}

export default Home;    