import {render, screen} from '@testing-library/react';
import TrialSignup from './TrialSignup';



// test if sign up button is present
test('renders sign up button', () => {
  render(<TrialSignup />);
  const linkElement = screen.getByText(/Sign up for trial/i);
  expect(linkElement).toBeInTheDocument();
});

// test if remove sign up button is present
test('renders remove sign up button', () => {
  render(<TrialSignup />);
  const linkElement = screen.getByText(/Remove sign up/i);
  expect(linkElement).toBeInTheDocument();
});

// test if company name is present
test('renders company name', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText("Company name is loading");
    expect(linkElement).toBeInTheDocument();
});

// test if trial name is present
test('renders trial name', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText("Trial name is loading");
    expect(linkElement).toBeInTheDocument();
});

// test if company email is present
test('renders company email', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText("Email is loading");
    expect(linkElement).toBeInTheDocument();
});

// test if description is present
test('renders description', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText("Description is loading");
    expect(linkElement).toBeInTheDocument();
});

// test if sign up button is enabled
test('renders sign up button enabled', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Sign up for trial/i);
    expect(linkElement).toBeEnabled();
});

// test if remove sign up button is disabled
test('renders remove sign up button enabled', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Remove sign up/i);
    expect(linkElement).toBeDisabled();
});

// test if sign up button is not disabled
test('renders sign up button not disabled', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Sign up for trial/i);
    expect(linkElement).not.toBeDisabled();
});

// test if remove sign up button is not enabled
test('renders remove sign up button not enabled', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Remove sign up/i);
    expect(linkElement).not.toBeEnabled();
});
