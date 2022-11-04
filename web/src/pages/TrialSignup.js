import {
    Paper,
    Box,
    Typography, Button
} from "@mui/material";
import * as React from "react";
import {useParams} from "react-router-dom";
import {TrialStore} from "../stores/TrialStore";
import {useEffect, useState} from "react";


function TrialSignup() {
    const id = useParams().id
    const store = new TrialStore(id);
    const [currentValues, setCurrentValues] = useState({} )

        useEffect(() => {
            async function fetchData() {
                setCurrentValues(await store.fetchTrial(id))
            }
            fetchData()
    }, [])

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
                                    {currentValues.company}
                                </Typography>
                                <Typography variant="h5" marginX={4}>
                                    {currentValues.trialname}
                                </Typography>
                                <Typography variant="body1" marginX={7} marginY={2}>
                                    filler text goes here:
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
                                    color="success"
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