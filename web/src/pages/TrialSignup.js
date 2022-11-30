import {
    Paper,
    Box,
    Typography, Button
} from "@mui/material";
import * as React from "react";
import {useParams} from "react-router-dom";
import{trialsStore} from "../stores/TrialsStore";
import {useEffect, useState} from "react";



function TrialSignup() {
    const id = useParams().id
    //const store = new TrialStore(id);
    const [currentValues, setCurrentValues] = useState({
        id: 0,
        company: {
            id: 0,
            email: "Email is loading",
            companyName: "Company name is loading",
        },
        trialname: "Trial name is loading",
        location: "Location is loading",
        description: "Description is loading"
    } )

    const [state, setState] = useState({
        subscribed: false,
    })
    useEffect(() => {
        async function fetchData() {
            setCurrentValues(await trialsStore.fetchTrial(id))
            setState({subscribed: await trialsStore.getSubscribed(id)})
        }
        fetchData().then(r => console.log("done"))
    }, [])
    const handleSubscribe = (event) => {
        event.preventDefault();
        trialsStore.postSubscription(id).then(() => {
            window.location.href = "/#/trials"
        })
    }
    const handleUnsubscribe = (event) => {
        event.preventDefault();
        trialsStore.deleteSubscription(id).then(() => {
            window.location.href = "/#/trials"
        })
    }

    return(
        <div>
            <Box
                sx={{
                    display: 'flex',
                    flexWrap: 'wrap',
                    '& > :not(style)': {
                        m: 6,
                        width: '100%',
                        height: '100%',
                    },
                }}
            >
                <Paper elevation={3}>
                    <div>
                        {(
                            <div>
                                <Typography variant="h4" component="div" margin={2}>
                                    {currentValues.company.companyName}
                                </Typography>
                                <Typography variant="h5" marginX={4}>
                                    {currentValues.trialname}
                                </Typography>
                                <Typography variant="body1" marginX={7} marginY={2}>
                                    {currentValues.company.email}
                                </Typography>
                                <Typography variant="body1" display="block" marginX={7} marginY={2} >
                                    {currentValues.description}
                                </Typography>
                            </div>
                        )}
                            <div align="right">
                                <Button
                                    variant="contained"
                                    sx={{ mt: 2, mb: 2, mr: 6}}
                                    size="large"
                                    color="error"
                                    disabled={!state.subscribed}
                                    onClick={handleUnsubscribe}
                                >Remove sign up
                                </Button>
                                <Button
                                    variant="contained"
                                    sx={{ mt: 2, mb: 2, mr: 6}}
                                    size="large"
                                    color="success"
                                    disabled={state.subscribed}
                                    focusRipple={false}
                                    onClick={handleSubscribe}
                                >
                                    Sign up for trial
                                </Button>
                            </div>
                        </div>
                </Paper>
            </Box>
        </div>
    )

}

export default TrialSignup;