import {render, screen} from '@testing-library/react';
import TrialSignup from './TrialSignup';



// test if sign up button is present
test('renders sign up button', () => {
    render(<TrialSignup />);
    const linkElement = screen.getByText(/Sign Up for trial/i);
    expect(linkElement).toBeInTheDocument();
});