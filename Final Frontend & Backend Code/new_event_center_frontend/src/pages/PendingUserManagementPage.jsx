import React from "react";
import NavBar from "../components/NavBar";
import DataGridForPendingUsers from "../components/DataGridForPendingUsers"

function PendingUserManagementPage(){
    return<div>

        <NavBar/>
        <DataGridForPendingUsers/>
    </div>;
}

export default PendingUserManagementPage;
