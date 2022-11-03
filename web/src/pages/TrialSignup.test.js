import {render, screen} from '@testing-library/react';
import TrialSignup from './TrialSignup';


// test for trial signup page
 test('renders trial signup page', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Lacus viverra vitae congue eu consequat ac felis donec. Imperdiet sed euismod nisi porta. Nec feugiat nisl pretium fusce. Consequat semper viverra nam libero justo laoreet sit amet. Amet facilisis magna etiam tempor. Erat nam at lectus urna duis. A lacus vestibulum sed arcu. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur vitae. Quam elementum pulvinar etiam non quam lacus suspendisse faucibus. Sit amet dictum sit amet. Et malesuada fames ac turpis egestas sed tempus. Ut venenatis tellus in metus vulputate eu. Et sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque. Tincidunt arcu non sodales neque sodales. Et malesuada fames ac turpis egestas maecenas. Nunc eget lorem dolor sed viverra ipsum nunc aliquet. Consectetur adipiscing elit pellentesque habitant morbi tristique senectus et netus. Pretium fusce id velit ut. Sodales ut etiam sit amet nisl purus./i);
    expect(linkElement).toBeInTheDocument();
});


// test for trial signup page company name
test('renders trial signup page company name', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Company name goes here/i);
    expect(linkElement).toBeInTheDocument();
});

// test if sign up button is present
test('renders sign up button', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Sign Up for trial/i);
    expect(linkElement).toBeInTheDocument();
});