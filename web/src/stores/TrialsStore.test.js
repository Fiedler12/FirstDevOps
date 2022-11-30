import {trialsStore} from './TrialsStore';



// test if fetchTrials returns an array of trials
test('fetchTrials returns an array of trials', async () => {
    trialsStore.fetchTrials().then((result) => {
        expect(result).toBeInstanceOf(Array);
    });

});

// test if fetchTrial with a valid id returns a trial
test('fetchTrial with valid id returns a trial', async () => {
    const trial = trialsStore.fetchTrial(1453)
    expect(trial).not.toBeNull();
});

// test if fetchTrial with an invalid id returns null
test('fetchTrial with invalid id returns null', async () => {
    trialsStore.fetchTrial(-1).then((result) => {
        expect(result).toBeNull();
    })
});
// test if fetchSpecific returns a disease
test('fetchSpecific returns a disease', async () => {
    trialsStore.fetchSpecific("cancer").then((result) => {
        expect(result).toBeInstanceOf(Array);
    })
})